public class Ejercicio6 {

    /*PROBLEMAS ENCONTRADOS
    1. Anidación excesiva: Hay 3 niveles de if anidados
    2. Manejo de errores silencioso: si gateway.charge() falla, el catch solo tien un comentario y
        no hace nada
    3. Retorno de null como codigo de estado
    4. Nombres poco descriptivos
     */

    //Refactorización
    public class PaymentProcessor {

        private final PaymentGateway gateway;

        public PaymentProcessor(PaymentGateway gateway) {
            this.gateway = gateway;
        }

        public Receipt processPayment(Payment payment) {
            validatePayment(payment);

            try {
                return gateway.charge(payment);
            } catch (Exception e) {
                throw new PaymentProcessingException("Error al procesar el pago con el gateway", e);
            }
        }

        private void validatePayment(Payment payment) {
            if (payment == null) {
                throw new IllegalArgumentException("El pago no puede ser nulo");
            }
            if (payment.getAmount() <= 0) {
                throw new IllegalArgumentException("El monto debe ser mayor a cero");
            }
            if (payment.getCard() == null) {
                throw new IllegalArgumentException("Debe especificarse una tarjeta");
            }
        }
    }
    //Excepcion custom
    public class PaymentProcessingException extends RuntimeException {
        public PaymentProcessingException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
