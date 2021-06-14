public class
MatricesMult {
    public static void main(String[] args) {
        int i,j,p=3,q=2,m=2,n=3,k;
        int a[][]={{1,2,3},{4,5,6}};
        int b[][]={{1,2},{3,4},{5,6}};
        int c[][]=new int[2][2];
        for(i=0;i<m;i++) {
            for(j=0;j<q;j++) {
                c[i][j]=0;
                for(k=0;k<n;k++)
                    c[i][j]=c[i][j]+a[i][k]*b[k][j];
            }
        }
        for(i=0;i<m;i++){
            for(j=0;j<q;j++){
                System.out.println(c[i][j]);
            }

        }
    }


}
