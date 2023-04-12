import java.io.*;
import java.util.*;

public class silv1_1325 {
    public static int N, M; //N:컴퓨터 개수, M:간선 개수
    public static ArrayList<Integer>[] list;
    public static boolean[] visited;
    public static int[] distance; //각 노드에 몇번 방문했는지

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        distance=new int[N+1];

        for(int i=1; i<=N;i++){
            list[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine(), " ");
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            //System.out.println("A: "+A+"&& B: "+B);
            list[A].add(B);
            //System.out.println(list[A]);
        }

        for(int i=1;i<=N;i++){
            visited=new boolean[N+1];
            //System.out.println(i+"인덱스 돌기 ");
            dfs(i);
        }
        StringBuilder sb = new StringBuilder();
        int max=0;
        for(int i=1; i<=N; i++){
            if(distance[i]>max) max=distance[i];
        }
        for(int i=1; i<=N; i++){
            if(max==distance[i]) sb.append(i+" ");
        }
        System.out.println(sb.toString());
    }
    private static void dfs(int i){
        visited[i]=true;
        for(int k=1;k<=N;k++){
            //System.out.println("visited[i] : "+visited[k]);
        }
        //System.out.println("list[i] : "+list[i]);
        for(int a: list[i]){
            //System.out.println("a: "+a);
            if(!visited[a]){
                distance[a]++;
                //System.out.println("a:"+a+",distance["+a+"]="+distance[a]);
                dfs(a);
            }
        }
    }
}
