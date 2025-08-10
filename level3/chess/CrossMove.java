public interface CrossMove extends Movable {
    @Override
    default void move(Spot start, Spot end, Board board){

    }
}
