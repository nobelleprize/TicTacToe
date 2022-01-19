import java.util.Arrays;

public class TicTacToeBoard{
    String[] board;
    int turn;

    public TicTacToeBoard()
    {
        board = new String[9];
        turn = 1;
    }

    public String refreshBoard(int clicked)
    {
        if(turn == 1)
        {
            board[clicked] = "X";
            turn -= 1;
        }
        else
        {
            board[clicked] = "O";
            turn += 1;
        }
        return board[clicked];
    }

    public void resetBackEnd()
    {
        for(int i=0; i < 9; i++)
        {
            board[i] = null;
        }
        turn = 1;
    }

    public boolean checkTie()
    {
        for(int i=0; i < 9; i++)
        {
            if(board[i] == null)
            {
                return false;
            }
        }
        return true;
    }

    public String checkWinner()
    {
        if(checkTie())
        {
            return "tie";
        }

        else if((board[0] == board[1]) && (board[1] == board[2]) && (board[0] != null))
        {
            return board[0];
        }

        else if((board[3] == board[4]) && (board[4] == board[5]) && (board[3] != null))
        {
            return board[3];
        }

        else if((board[6] == board[7]) && (board[7] == board[8]) && (board[6] != null))
        {
            return board[6];
        }

        else if((board[0] == board[4]) && (board[4] == board[8]) && (board[0] != null))
        {
            return board[0];
        }

        else if((board[2] == board[4]) && (board[4] == board[6]) && (board[2] != null))
        {
            return board[2];
        }

        else if((board[0] == board[3]) && (board[3] == board[6]) && (board[0] != null))
        {
            return board[0];
        }

        else if((board[1] == board[4]) && (board[4] == board[7]) && (board[1] != null))
        {
            return board[1];
        }

        else if((board[2] == board[5]) && (board[5] == board[8]) && (board[2] != null))
        {
            return board[2];
        }

        return null;
    }

}
