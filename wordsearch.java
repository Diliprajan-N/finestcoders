public class wordsearch {
    public boolean exist(char[][] board, String word){
        int m=board.length;
        int n=board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,String word,int index,int row,int col){
        if(index==word.length()){
            return true;

        }
        if(row<0||row>=board.length||col<0||col>=board[0].length||board[row][col]!=word.charAt(index)){
            return false;
        }

        char temp = board[row][col];
        board[row][col]='#';

        boolean found =dfs(board, word, index+ 1, row-1, col)||dfs(board,word, index+1, row+1,col)||
        dfs(board, word, index+1, row, col-1) || dfs(board, word, index+1,row,col+1);

        board[row][col]=temp;
        return found;

    }
    public static void main(String[]args){
        wordsearch ws=new wordsearch();
        System.out.println("Grid is: ");
        char[][]board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
            System.out.print(board[i][j]);
        }System.out.println();}

        System.out.println(ws.exist(board,"ABCCED"));
     
    }
}
