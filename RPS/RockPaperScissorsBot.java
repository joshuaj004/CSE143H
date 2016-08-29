import java.util.List;
/* RockPaperScissors rules:
 *    Rock beats Scissors
 *    Paper beats Rock
 *    Scissors beats Paper
 */

/* You should write a class that implements this interface.
 * The one method is all that matters. 
 */

public interface RockPaperScissorsBot {
    /* This function should return one of the three following strings:
     *    "Rock", "Paper" "Scissors"
     *
     * The argument is a list of these three strings indicating the moves
     * that the opponent has previously made. 
     */
        
    public String makeMove(List<String> previousMoves);
}