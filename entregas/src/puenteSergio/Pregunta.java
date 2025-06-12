public enum Pregunta {
    UNO("Vista pública de clases", true),
    DOS("Vista pública de objetos", false),
    TRES("Vista privada de clases", true);

    private final String enunciado;
    private final boolean espacioAntes;

    Pregunta(String enunciado, boolean espacioAntes) {
        this.enunciado = enunciado;
        this.espacioAntes = espacioAntes;
    }

    public String enunciado() {
        return this.enunciado;
    }

    public boolean espacioAntes() {
        return this.espacioAntes;
    }
}