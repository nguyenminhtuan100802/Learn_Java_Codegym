package Document.TITV.OOP.CoffeeBill;

public class CoffeeBill {
    private String nameTypeOfCoffee;
    private double pricePerKg;
    private double amountOfKg;
    public CoffeeBill(String nameTypeOfCoffee, double pricePerKg, double amountOfKg) {
        this.nameTypeOfCoffee = nameTypeOfCoffee;
        this.pricePerKg = pricePerKg;
        this.amountOfKg = amountOfKg;
    }
    public double calculateSumMoney() {
        return this.amountOfKg * this.pricePerKg;
    }
    public boolean isUserBuyMoreThan(double amountOfKg){
        return this.amountOfKg > amountOfKg;
    }
    public boolean isSumMoneyOver(double amountOfMoney){
        return this.calculateSumMoney() > amountOfMoney;
    }
    public double calculateSumMoneyDiscount(double percentDiscount){
        return this.calculateSumMoney() * percentDiscount / 100;
    }
    public double calculateFinalMoney(double percentDiscount){
        return this.calculateSumMoney() - this.calculateSumMoneyDiscount(percentDiscount);
    }

}
