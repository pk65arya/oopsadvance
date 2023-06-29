package com.oops;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private String StockName;
    private int Numberofshare;
    private Double Shareprice;


    public Stock(String stockName, int numberofshare, Double shareprice ) {
        this.StockName = stockName;
        this.Numberofshare = numberofshare;
        this.Shareprice = shareprice;

    }

    public String getStockName() {
        return StockName;
    }

    public int getNumberofshare() {
        return Numberofshare;
    }

    public double getShareprice() {
        return Shareprice;
    }




}

class Account{

//    private  List<Stock> shares;
//    private double sellprice;

    private double amount=10000;

    public Account(double amount) {
//        this.shares = shares;
//        this.sellprice=sellprice;
        this.amount=amount;
    }

    public String debit(int amnt){
        if(amnt>amount){
            System.out.println("Debit amount exceeded account balance.");
        }
        return "";
    }



}
    class  Stockportfolio {
        private List<Stock> shares;

        public Stockportfolio() {
            this.shares = new ArrayList<>();
        }

        public void addShare(Stock stock) {
            shares.add(stock);
        }
        public void removeShare(Stock stock){
            shares.remove(stock);
        }
        public void SharePrice(Stock stock){
            shares.add(stock);
        }
      public void totalBuy(){
           double totalpurchase=0;
            if (shares.isEmpty()){
                System.out.println("empty");
            }else {
                for (Stock share:shares
                     ) {
                   double totalBuy=(share.getShareprice()*share.getNumberofshare());
                   totalpurchase +=totalBuy;


                    }
                System.out.println("total purchasing : "+totalpurchase);

                }
            }

        public void stockCart(){
            if(shares.isEmpty()){
                System.out.println("stock item is empty");
            }else {
                for(Stock share:shares){
                    System.out.println(share.getStockName()+"  "+ share.getNumberofshare()+ " "+share.getShareprice());
                }
            }
        }
public double getTotal(){
            double total=0.0;
    for (Stock share:shares ) {

       total +=share.getShareprice();
    }
    return total;
}
public void orderShare(){
            if (shares.isEmpty()){
                System.out.println("Shares item is empty");
            }else {
                double total=getTotal();
                System.out.println("total amount is : $"+total);
                System.out.println("order is placed successfully");
            }

}

//        public int sellShare(String name,int quantity,double sellprice){
//
//            if(name.equalsIgnoreCase(shares.))
//
//            int totalprice=0;
//            if(shares.isEmpty()){
//                System.out.println("share is empty:");
//            }else {
//
//            }
  //      }





        public static void main(String[] args) {
            Stock stock=new Stock("relaince",2,560.56);
            Stock stock1=new Stock("asian paints",2,250.25);

            Stockportfolio stockportfolio=new Stockportfolio();
            stockportfolio.addShare(stock);
            stockportfolio.addShare(stock1);

            stockportfolio.stockCart();
            stockportfolio.getTotal();
            stockportfolio.orderShare();
            stockportfolio.totalBuy();

        }
    }

