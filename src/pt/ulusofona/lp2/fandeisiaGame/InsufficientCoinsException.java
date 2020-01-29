package pt.ulusofona.lp2.fandeisiaGame;

public class InsufficientCoinsException extends Exception {

    int moedasLdr;
    int moedasRes;

    public InsufficientCoinsException(String message, int moedasLdr, int moedasRes) {
        super(message);
        this.moedasLdr = moedasLdr;
        this.moedasRes = moedasRes;
    }

    public boolean teamRequiresMoreCoins(int teamId) {
        return getRequiredCoinsForTeam(teamId) > 50;
    }

    public int getRequiredCoinsForTeam(int teamID) {
        if (teamID == 10) {
            return (moedasLdr * -1) + 50;
        } else {
            return (moedasRes * -1) + 50;
        }
    }
}
