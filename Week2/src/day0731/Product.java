package day0731;

public class Product {// 과제 4
    private String productName;
    private int price;

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    public void printInfo(){
        System.out.println("상품명: "+ this.productName+", 가격: "+ this.price);
    }

    public static void main(String[] args) {
        Product[] arr = new Product[3];
        arr[0] = new Product("아이폰", 1300000);
        arr[1] = new Product("에어팟", 250000);
        arr[2] = new Product("맥북", 2000000);

        for(Product p : arr){
            p.printInfo();
        }
    }
}
