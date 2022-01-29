package solvedArchive.Graph;

public class FloodFill{

    public static void main(String[] args) {

        int image[][] = {{1,1,1},
                        {1,1,0},
                        {1,0,1}};

        int arr[][] = floodFill(image, 1, 1, 2);

        for(int i[] : arr){
            for(int j : i){
                System.out.print(j+" ");
            }
            System.out.println();
        }

    }

    static int[][] floodFill(int image[][], int sr, int sc, int newColor){

        floodFillHelper(image, sr, sc, image[sr][sc], newColor);

        return image;
    }

    static void floodFillHelper(int image[][], int row, int col, int oldColor ,int newColor){

        if(row<0 || col<0 || row>=image.length || col>=image[0].length)
            return;

        if(image[row][col]!=oldColor || image[row][col]==newColor)
            return;

        image[row][col] = newColor;

        floodFillHelper(image, row, col+1, oldColor, newColor);
        floodFillHelper(image, row+1, col, oldColor, newColor);
        floodFillHelper(image, row, col-1, oldColor, newColor);
        floodFillHelper(image, row-1, col, oldColor, newColor);
    }

}
