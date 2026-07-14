public class Ejercicio5 {

    /*PROBLEMAS ENCONTRADOS
    DRY: Los dos metodos hacen lo mismo (precio * 0.1). si el descuento cambia, hay que tocarlo
    en dos lugares
    Comentarios: Son redundantes, repiten literalmente lo que dice el codigo
     */

    //Refactorizacion
    public class DiscountService {

        private static final double VIP_DISCOUNT_RATE = 0.15;
        private static final double PREMIUM_DISCOUNT_RATE = 0.15;

        public double calcVipDiscount(double price) {
            return calculateDiscount(price, VIP_DISCOUNT_RATE);
        }

        public double calcPremiumDiscount(double price) {
            return calculateDiscount(price, PREMIUM_DISCOUNT_RATE);
        }

        private double calculateDiscount(double price, double rate) {
            return price * rate;
        }
    }
}
