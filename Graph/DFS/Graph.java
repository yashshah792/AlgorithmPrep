import java.util.Stack;

public class Graph{
    private final int maxVertice = 20;
    private Vertex vertexList[];
    private int vertexCount;
    private Stack s;
    private int adjMatrix[][];

    public Graph(){
        vertexList = new Vertex[maxVertice];
        adjMatrix = new int[maxVertice][maxVertice];
        vertexCount = 0;
        for(int i = 0; i < maxVertice; i++){
            for(int j =0; j < maxVertice; j++){
                adjMatrix[i][j] = 0;
            }
        }
        s = new Stack<>();
    }

    public void addVertex(char la){
        vertexList[vertexCount++] = new Vertex(la);
    }

    public void addEdge(int start, int end){
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displayVertex(int v){
        System.out.println(vertexList[v].label);
    }

    public int getUnvisitedVertex(int v){
        for(int i = 0; i < vertexCount; i++){
            if(adjMatrix[v][i] == 1 && vertexList[i].visited==false){
                return i;
            }
        }
        return -1;
    }

    public void dfs(){
        vertexList[0].visited = true;
        displayVertex(0);
        s.push(0);
        while(!s.isEmpty()){
            //integer value for the object pushedinto the stack s
            int n = 0;
            int v = getUnvisitedVertex(n);
            if(v == -1){
                s.pop();
            }else{
                vertexList[v].visited = true;
                displayVertex(v);
                s.push(v);
            }
        }
        for(int j = 0; j < vertexCount; j++){
            vertexList[j].visited = false;
        }
    }
}