package Document.TITV.OOP.CoffeeBill;

public class Main {
    public static void main(String[] args) {
        CoffeeBill coffeeBill = new CoffeeBill("Trung Nguyên", 100000, 4.5);

        System.out.println("Gía mua cà phê: " + coffeeBill.calculateSumMoney());

        if (coffeeBill.isUserBuyMoreThan(4)){
            System.out.println("Người dùng mua nhiều kg hơn dự kiến");
        } else {
            System.out.println("Người dùng mua ít kg hơn dự kiến");
        }

        if (coffeeBill.isSumMoneyOver(500000)){
            System.out.println("Người dùng chi nhiều tiền hơn dự kiến");
        } else {
            System.out.println("Người dùng chi ít tiền hơn dự kiến");
        }

        System.out.println("Gía tiền người dùng được giảm: " + coffeeBill.calculateSumMoneyDiscount(20));
        System.out.println("Gía tiền người dùng cần trả sau giảm giá: " + coffeeBill.calculateFinalMoney(20));
    }
}
