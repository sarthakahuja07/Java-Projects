import java.util.Random;
class SnakeLadder {
    public static void main(String[] args) {
        int[][] layer1= {{1,0,0},{0,0,2},{0,1,2}};
        int[][] layer2={{-2,0,0},{0,0,3},{0,-1,2}};
        int[] player={1,1,1,1};
        int row;
        int column;
        int update;
        int dice;
        boolean isGame=true;
        Random random=new Random();
          while(isGame){
            for (int i=0;i<4;i++){
                row=2-((player[i]-1)/3);
                column=(player[i]-1)%3;
                dice=random.nextInt(7);
                if(dice==0){
                    dice=random.nextInt(7);
                }
                System.out.println("Dice thrown by player "+(i+1)+": "+dice);
                if(dice+ player[i]>9){
                    System.out.println("Doesn't move ");
                    continue ;
                }
                else if(column+dice<=2){
                    column+=dice;
                }else{
                    row-=(column+dice)/3;
                    column=(column+dice)%3;
                }
                if(layer1[row][column]==2){
                    update=layer2[row][column];
                    if(column+update>2){
                        row-=(column+update)/3;
                    }
                    column=(column+update)%3;
                }
                else if(layer1[row][column]==1){
                    update=layer2[row][column];
                    if(column+update>=0){
                        column=(column+update)%3;
                    }else{
                        row+=(2-(column+update))/3;
                        column=(3+(column+update))%3;
                    }
                }
                player[i]=((2-row)*3)+column+1;
                System.out.println("Player "+(i+1)+" location :"+player[i]);
                if(player[i]>=9){
                    System.out.println("Player "+(i+1)+" won");
                    isGame=false;
                    break;
                }

            }
        }    }
}





