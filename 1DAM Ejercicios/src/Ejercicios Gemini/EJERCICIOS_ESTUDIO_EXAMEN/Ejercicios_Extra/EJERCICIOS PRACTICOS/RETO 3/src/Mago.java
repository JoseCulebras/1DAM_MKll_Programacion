public class Mago extends Personaje{
    private int mana;

    public Mago(String nombre, int nivel, int puntosVida, int mana){
        super(nombre, nivel, puntosVida);
        this.mana = mana;
    }

    public int getMana() {return mana;}
    public void setMana(int mana) {this.mana = mana;}

    @Override
    public void recibirDanio(int danio) {
        // CORREGIDO: Calculamos y actualizamos la vida real en el objeto
        int nuevaVida = getPuntosVida() - danio;

        setPuntosVida(nuevaVida);
    }

    @Override
    public int atacar() {

        if(mana >  0){
            mana--; // CORREGIDO: Reducimos directamente el atributo de la clase

            return getNivel() * 10;

        }else{
            return 1;
        }
    }
}
