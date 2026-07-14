public class Ejercicio4 {

    //Problemas encontrados
    /*1. Nombres poco descriptivos
      2. El Metodo hace demasiadas cosas
      3. Flag argument
      4. Magic number
      5. Magic strings como codigos de retorno
      6. Falta de manejo de errores
      7. Mezcla de logica de negocio con efectos secundarios
     */


//Refactorización

    public class OrderService {
        private static final double PREMIUM_DISCOUNT_RATE = 0.9; // 10% de descuento

        private final OrderRepository repo;
        private final EmailService emailSvc;

        public OrderService(OrderRepository repo, EmailService emailSvc) {
            this.repo = repo;
            this.emailSvc = emailSvc;
        }

        public void processOrder(Order order, boolean isPremiumCustomer) {
            validateOrder(order);

            double total = calculateTotal(order);
            total = applyDiscountIfPremium(total, isPremimCustomer);

            order.setTotal(total);
            repo.save(order);
            notifyCustomer(order);
        }

        private void validateOrder(Order order) {
            if (order == null || order.getItems().isEmpty()) {
                throw new IllegalArgumentException("El pedido no puede ser nulo o estar vacío");
            }
        }

        private double calculateTotal(Order order) {
            double total = 0;
            for (Item item : order.getItems()) {
                total += item.getPrice() * item.getQty();
            }
            return total;
        }
    .

        private double applyDiscountIfPremium(double total, boolean isPremiumCustomer) {
            return isPremiumCustomer ? total * PREMIUM_DISCOUNT_RATE : total;
        }

        private void notifyCustomer(Order order) {
            emailSvc.send(order.getUser().getEmail(), "Tu pedido fue procesado");
        }
    }
}