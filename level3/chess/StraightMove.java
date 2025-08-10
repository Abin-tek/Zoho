public interface StraightMove extends Movable{
    @Override
    default void move(Spot start, Spot end, Board board) {
        char start_file = start.getFile();
        char end_file = end.getFile();
        char start_rank = start.getRank();
        char end_rank = end.getRank();

//        if (start_rank != end_rank && start_file != end_file)
//            return false;
//
//        if (start_file < end_file || start_rank < end_rank) {
//            step = 1;
//        } else {
//            step = -1;
//        }
    }
}
