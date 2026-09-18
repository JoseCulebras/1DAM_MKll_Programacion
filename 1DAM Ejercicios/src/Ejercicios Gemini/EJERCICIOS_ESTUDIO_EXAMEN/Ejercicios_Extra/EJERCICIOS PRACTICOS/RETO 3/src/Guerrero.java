public class Guerrero extends Personaje{
    private int armadura;

    public Guerrero(int armadura, String nombre, int nivel, int puntosVida){
        super(nombre, nivel, puntosVida);
        this.armadura = armadura;
    }

    public int getArmadura() {return armadura;}
    public void setArmadura(int armadura) {this.armadura = armadura;}

    @Override
    public void recibirDanio(int danio) {
        int danioReal = danio - armadura;

        // Si la armadura mitiga el daño entero, no restamos nada
        if(danioReal > 0){
            int nuevaVida = getPuntosVida() - danioReal;
            // CORREGIDO: Actualizamos el atributo real del objeto usando el setter
            setPuntosVida(nuevaVida);
        }
    }

    @Override
    public int atacar() {
        return getNivel() * 5;
    }
}
