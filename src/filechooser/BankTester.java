package filechooser;

import java.util.ArrayList;
import java.util.Scanner;

public class BankTester { 
	//	・メソッド
	//	クラスメソッド名：getListIndex
	//	引数：int型num、BankAccount型ArrayList
	//	戻り値：int型
	private static int getListIndex(int num,ArrayList<BankAccount> List) {
		//		処理：ArrayListのsize()でループ文を作り、ArrayListにあるBankAccountクラスのaccount_numの値と、
		//		引数で受け取ったnumの値が一致した場合は、インデックスの値を戻り値として返す。
		//		一致しない場合は、戻り値として-1を返す。
		for(int i=0;i<List.size();i++) {
			if(List.get(i).getAccount_num() == num) {
				return i;
			}
		}
		return -1;
	}

	//	クラスメソッド名：main（メインメソッド）
	//	処理手順：
	public static void main(String[] args) { 
		//	①	BankAccount型のArrayListを宣言する。
		ArrayList<BankAccount> List = new ArrayList<BankAccount>();
		//	②	CsvFileOperationクラスを宣言する。
		CsvFileOperation csv = new CsvFileOperation();
		//	③	Scannerクラスを宣言する
		Scanner sc = new Scanner(System.in);
		//	④	「口座データを読み込みますか？y:はい　n:いいえ」を表示する
		System.out.println("口座データを読み込みますか？y:はい　n:いいえ");
		//	⑤	キーボードから入力し、「yまたはY」のときは以下の処理を行う
		//		→CsvFileOperationクラスのfileexistsメソッドを呼び出す。
		//	ファイルがある時はbuffFileReaderメソッド（引数：ArrayList）を呼び出し、「ファイルを読み込みました」と表示する。
		String yn = sc.nextLine();
		if(yn.equals("y")||yn.equals("Y")) {
			
			if(csv.fileexists()) {//existsの戻り値はboolean型
				csv.buffFileReader(List);
				System.out.println("ファイルを読み込みました");
			}else {
				//	ファイルがない場合は、「ファイルがありませんでした」と表示する。
				System.out.println("ファイルがありませんでした");
			}
		}

		//	⑥do-while文を作り、これ以降の内容はdo-while文の中に作る。
		do{
			//	do-while文のループ条件は無限ループとし、キーボードからの入力は全てnextLine()メソッドを使うように記述すること。
			//⑦「操作をしたい番号を入力してください。」
			//「1:口座作成　2:口座一覧表示　3:入金　4:出金　5:送金　99:終了」を表示する。
			System.out.println("操作をしたい番号を入力してくださyい。");
			System.out.println("1:口座作成　2:口座一覧表示　3:入金　4:出金　5:送金　99:終了");
			int a = sc.nextInt();
			//⑧if文を使い、口座作成の時、口座一覧表示の時、入金の時、出金の時、
			//　送金の時、終了の時、それ以外の時になるように分岐条件を作る。
			if(a == 1) {
				//⑨口座作成処理内容
				//	1.「口座を作成したい名前を入力してください」と表示する
				//	2.キーボードから名前を入力し、BankAccountクラスのコンストラクタに名前を渡してインスタンスを生成したあと、ArrayListに追加する。
				//	3.「口座を作成しました。」と表示する。
				System.out.println("口座を作成したい名前を入力してください");
				String name = sc.nextLine();
				List.add(new BankAccount(sc.nextLine()));//コンストラクタ①に渡す
				System.out.println("口座を作成しました。");

			}else if(a == 2) {
				//⑩口座一覧表示処理内容
				//	1.	ArrayListのsize()でfor文を作り、BankAccountクラスのshowAccountメソッドを呼び出す
				//	2.	「一覧を表示しました」と表示する
				for(int i=0;i<List.size();i++) {
					List.get(i).showAccount();
					System.out.println("一覧を表示しました");
				}

			}else if(a == 3) {
				//⑪入金処理内容
				//	1.「口座番号を指定してください」と表示し、キーボードから入力させる。
				System.out.println("口座番号を指定してください");
				int num = sc.nextInt();
				//	2.「入金する金額を入力してください」と表示し、キーボードから入力させる。
				System.out.println("入金する金額を入力してください");
				int money = sc.nextInt();

				//	3. getListIndexメソッドを呼び出し、指定した口座番号とArrayListを引数として渡す。
				//	戻り値として受け取った値（インデックス）が-1ではない時、
				//	ArrayListのgetメソッドを呼び出してから、depositメソッドに入金する金額を渡して処理する。
				if(getListIndex(num,List) != -1) {
					List.get(getListIndex(num,List)).deposit(money);
					//	4.「入金処理が完了しました。」と表示する。
					System.out.println("入金処理が完了しました。");
				}

			}else if(a == 4) {
				//⑫出金処理内容
				//	1.「口座番号を指定してください」と表示し、キーボードから入力させる。
				System.out.println("口座番号を指定してください");
				int num = sc.nextInt();
				//	2.「出金する金額を入力してください」と表示し、キーボードから入力させる。
				System.out.println("出金する金額を入力してください");
				int money = sc.nextInt();
				//	3. getListIndexメソッドを呼び出し、指定した口座番号とArrayListを引数として渡す。
				//戻り値として受け取った値（インデックス）が-1ではない時、ArrayListのgetメソッドを呼び出してから、
				//withdrawメソッドに入金する金額を渡して処理する。

				if(getListIndex(num,List) != -1) {
					List.get(getListIndex(num,List)).withdraw(money);
					//	4.「出金処理が完了しました。」と表示する。
					System.out.println("出金処理が完了しました。");
				}


			}else if(a == 5) {
				//⑬送金処理内容
				//　1.「送金元口座番号を指定してください」と表示。
				System.out.println("送金元口座番号を指定してください");
				// キーボードから入力
				int soukinmoto = sc.nextInt();
				//　2.getListIndexメソッドを呼び出し、戻り値が-1ではない時は、送金先口座番号を入力させる。
				//	戻り値が-1のときは「送金元口座番号が存在しません」と表示する。

				if(getListIndex(soukinmoto,List) != -1) { //※送金元口座番号がある時

					//　3.「送金先口座番号を指定してください」と表示し、送金先口座番号をキーボードから入力させ、
					System.out.println("送金先口座番号を指定してください");
					int soukinsaki = sc.nextInt();

					//getListIndexメソッドを呼び出し、戻り値が-1ではないとき
					if(getListIndex(soukinsaki,List) != -1) {//△送金先口座番号がある時
						//送金する金額を入力させる。
						System.out.println("送金する金額を入力してください");
						int outmoney = sc.nextInt();
						//5.BankAccountクラスのtransferメソッドに、
						//送金元のAccountクラスと送金先のAccount、送金する金額を引数に渡す。
						//ArrayList.get(インデックス)で、送金元、送金先のAccountクラスのデータを取得する。
						BankAccount.transfer(List.get(getListIndex(soukinmoto,List)),List.get(getListIndex(soukinsaki,List)),outmoney);
						//6.「送金処理が完了しました。」と表示する。
						System.out.println("送金処理が完了しました。");

						//戻り値が-1のときは「送金先口座番号が存在しません」と表示する。
					}else if(getListIndex(soukinsaki,List) == -1){//△送金先口座番号がない時
						System.out.println("送金先口座番号が存在しません");
					}

				}else if(getListIndex(soukinmoto,List) == -1) {//※送金元口座番号がない時
					System.out.println("送金元口座番号が存在しません");
				}


				}else if(a == 99) {
					//	⑭終了処理内容
					//	1.CsvFileOperationクラスのfilewriteメソッドを呼び、ArrayListを渡す。
					//	2.Breakさせdo-while文から抜け出す。
					csv.filewrite(List);
					break;

				}else {
					//	⑮それ以外の処理内容
					//	1.「操作番号が正しくありません」と表示する。
					System.out.println("操作番号が正しくありません");
				}

			

		}while (true); 
			//⑯do-while文を抜けたあと、「口座操作を終了しました。」と表示
			System.out.println("口座操作を終了しました。");

		}
	
}
