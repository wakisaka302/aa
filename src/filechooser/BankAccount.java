package filechooser;
//.BankAccountクラスを以下の内容で作成してください。
public class BankAccount {
	//・フィールド（修飾子はprivate)
	private String name;
	private int account_num;
	private int balance;
	private static int count = 0 ;
	//データ型	フィールド種類	変数名		用途
	//String		非static		name		口座名義
	//int		非static		account_num	口座番号
	//int		非static		balance		口座残高
	//int		static		count		口座作成個数
	
	//・コンストラクタ
	//①String型変数nameを引数に持つコンストラクタ
		public BankAccount(String name) {
		//処理内容：
		//1.	countの値をインクリメントして、setAccount_numメソッドに引数として渡す。
			setAccount_num(++count);
		//2.	setNameメソッドにnameを引数として渡す。
			setName(name);
		//3.	setBalanceメソッドに0の値を引数として渡す。
			setBalance(0);
		}
		//②String型変数name、int型変数account_num、int型変数balanceを持つコンストラクタ
		public BankAccount(String name,int account_num,int balance) {
		//処理内容：
		//1.	setNameメソッドにnameを引数として渡す。
			setName(name);
		//2.	setAccount_numにaccount_numを引数として渡す
			setAccount_num(account_num);
		//3.	setBalanceメソッドにbalanceを引数として渡す
			setBalance(balance);
		//4.	countの値をインクリメントする。
			count++;
		}	
		//・メソッド
		//①	name、account_num、balanceのsetter及びgetterを用意してください。
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAccount_num() {
			return account_num;
		}
		public void setAccount_num(int account_num) {
			this.account_num = account_num;
		}
		public int getBalance() {
			return balance;
		}
		public void setBalance(int balance) {
			this.balance = balance;
		}
		//②	depositメソッドを引数int型変数money、戻り値voidで宣言し、balanceの値をmoney分加算するプログラムを記述する。
		public void deposit(int money) {
			this.balance += money;
		}
		//③	withdrawメソッドを引数int型変数money、戻り値voidで宣言し、balanceの値をmoney分減算するプログラムを記述する。
		public void withdraw(int money) {
			this.balance -= money;
		}
		//④	showAccountメソッドを引数なし、戻り値voidで宣言し、
		//口座名義、口座番号、口座残高を順番に、各フィールドに対応したgetterメソッドを呼んで表示しましょう。
		public void showAccount() {
			System.out.println("口座名義：" + getName());
			System.out.println("口座番号：" + getAccount_num());
			System.out.println("口座残高：" + getBalance());
		}
		//⑤	transferメソッドを引数BankAccount型変数p1、BankAccount型変数p2、int型変数money、戻り値voidでstaticメソッドとして宣言し、
		//p1の口座残高を減らし、p2の口座残高を増やすメソッドをそれぞれ呼び出し、引数にmoneyを渡すプログラムを記述する。
		public static void transfer(BankAccount p1,BankAccount p2,int money) {
			p1.withdraw(money);
			p2.deposit(money);
		}
}
