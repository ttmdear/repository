package repo.java.lang.interfaces.case1;

public class User extends UserBase {

    @Override
    public MoveResult move() {
        return new MoveResult(20);
    }

    @Override
    public void play() {

    }
}
