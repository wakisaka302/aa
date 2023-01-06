package filechooser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//2.CsvFileOperationクラスを以下の内容で作成してください。
public class CsvFileOperation {
	//・フィールド
	private static String filepath; //CSVファイルの絶対パス
	//データ型	フィールド種類	変数名		用途
	//String		static		filepath		CSVファイルの絶対パス
	//・コンストラクタ
	public CsvFileOperation(){
		//引数：なし
		//処理：filepathにFileChooserTestクラスのstatic String filepath を代入する。(脇坂)
		filepath = FileChooserTest.getFilepath();
	}

	//・メソッド
	//インスタンスメソッド名：fileexists
	//引数：なし
	//戻り値：boolean
	public boolean fileexists() {
		//処理：Fileクラスに引数filepathを渡し、インスタンス化させる。
		//Fileクラスのexistsメソッドを用いて、ファイルが存在する場合はtrue、
		//存在しない場合はfalseを戻り値として返す。
		File file = new File(filepath);
		//ファイルが存在する場合は処理をする。
		if (file.exists()) {
			return true;
		}else {
			return false;
		}
	}

	//インスタンスメソッド名：buffFileReader
	//引数：BankAccount型のArrayList
	//戻り値：void
	public void buffFileReader(ArrayList<BankAccount> List) {
		//処理：1.filepathにあるファイルを１行ずつ読み込む（BufferedReaderクラスを使う）
		//　※１行は「名前,口座番号,口座残高」の形で読み込む
		//　2.読み込んだ１行を、String型メソッドのsplitを「,」で区切って処理する。
		//	※口座番号と口座残高についてはInteger.parseIntを使う必要がある。	

		try {
			File file = new File(filepath);
			
			//ファイルが存在する場合は処理をする。
			if (file.exists()) {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line;
				while ((line = br.readLine()) != null) {
					//ファイルから1行読み込んだ内容を処理する
					//CSVファイルは「,」でsplitする
					String[] str = line.split(",");
					//クラス配列に入れる等その他の処理に繋げていく

					////////////////////////////////////////////////////
					//3.BankAccountクラスに区切って処理した名前、口座番号、口座残高を順番に
					//コンストラクタに引数として渡してインスタンス化させた後、引数で受け取ったArrayListにインスタンスを追加する。
					////////////////////////////////////////////////////

					//String name = str[0];
					//int num = Integer.parseInt(str[1]);
					//int balance = Integer.parseInt(str[2]);

					BankAccount b = new BankAccount(str[0],Integer.parseInt(str[1]),Integer.parseInt(str[2]));
					List.add(b);
				}

				br.close();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//インスタンスメソッド名：filewrite
	//引数：BankAccount型のArrayList
	//戻り値：void
	public void filewrite(ArrayList<BankAccount> List) {
		//処理：1.filepathにあるファイルに１行ずつ書き込む(BufferedWriterクラスを使う)
		try {
			File file = new File(filepath);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			//2.引数で受け取ったArrayListのsize()でfor文を回し、
			for(int i=0;i<List.size();i++) {
				//ArrayListにあるBankAccountクラスの各フィールドをgetメソッドを使い取得する。
				//取得した各フィールドの値を、BufferedWriterクラスのwriteメソッドを使い、
				//「口座名義,口座番号,口座残高」の形でファイル出力する。
				//１行分出力した後、newLine()メソッドを使って改行する。
				
				//※↓csv書き込みの時のテンプレ
				bw.write(List.get(i).getName() +","+ List.get(i).getAccount_num() +","+ List.get(i).getBalance());//CSV形式に合わせてStringの文字列にして書く
				bw.newLine();//改行
			}
			
			bw.close();
			
		}catch(IOException e) {
			System.out.println(e);
		}



	}





}
