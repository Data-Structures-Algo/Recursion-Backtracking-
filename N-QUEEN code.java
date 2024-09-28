public class NQueen {
    public static void main (String args[]){
        int n=4; 
        char[][]arr=new char[n][n];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]='.';  //Intially we print "."
            }
        }
        nQueens(arr, 0); //Recursive call 

    }
    private static void print(char[][] arr){ //fuunction to print arr
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static boolean isSafe(char[][]arr,int row,int col){ //FN to check if placing is safe for the Queen
        //Checking column 
        for(int i=0;i<row;i++){
            if(arr[i][col]=='Q'){ // here it checks if Q is present  at row[o]fixed and vary from col[0] to col[n]
                return false;
            }
        }
        //Diagonal 1
        for(int i=row-1,j = col +1; i>=0 && j<arr[0].length; i--,j++){ //here it checks for upright diagonal _/ 
            if(arr[i][j]=='Q'){
                return false;
            }
        }
        //Diagonal 2
        for(int i=row-1,j=col-1; i>=0 && j>=0; i--,j--){ //here it checks for downleft diagonal /` 
            if(arr[i][j]=='Q'){
                return false;
            }
        }
        return true; // if any of that doesnot conflict return true


    }
    private static void nQueens(char[][]arr,int row){
        if(row==arr.length){
            print(arr); //print the array if row==n
            System.out.println("____________"); //adds a seperating line
            return;
        }
        for(int col=0;col<arr[0].length;col++){
            if(isSafe(arr,row,col)){ //checks if it is safe to place at this postion
                arr[row][col]='Q';
                nQueens(arr, row+1); //Recursive call to baktrack anb check the remaining subproblem
                arr[row][col]='.'; //amd resets it to intial '.'
            }
        }
    }
    
}
