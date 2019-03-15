public class CARD extends History  {
    private int Cardnumber;
    private double Balance;
    public CARD(int getCardnumber,double getBalance){
        Cardnumber=getCardnumber;
        Balance=getBalance;

    }
    public double getBalance() {

        return Balance;
    }

    public boolean findCard(int number) {

        if (number == Cardnumber) {
            return  true;
        }
        return false;
    }


    public void deposit(double amount){
        Balance= Balance + amount;

    }

    public boolean withdrawal(double amount) {
        if (amount>Balance)
            return false;
        else {
            Balance = Balance -  amount;
            return true;

        }
    }
}



