package modeler;

public class Account {

    private String pseudo;
    private int xp;
    public Account(String pseudo, int xp){
        this.pseudo = pseudo;
        this.xp = xp;
    }
    public String getPseudo() {
        return this.pseudo;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    public int getXp() {
        return this.xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    // Calcul du level à partir de l'xp
    public int getLevel() {
        return 1 + (xp / 50);
    }

    public static void main(String[] args){
        Account player1 = new Account("NinjaMaster", 120);
        System.out.println(player1.getLevel());
    }

}

