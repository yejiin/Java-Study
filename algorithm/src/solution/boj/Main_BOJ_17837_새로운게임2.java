package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 출력 : 게임이 종료되는 턴의 번호
public class Main_BOJ_17837_새로운게임2 {

    static int N, K;
    static int[][] board;

    static Map<Integer, Piece> pieces;  // 체스말 위치 저장 map
    static List<Integer>[][] pieceBoard;  // 체스말이 올려져 있는 이차원 배열

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pieces = new HashMap<>();
        pieceBoard = new List[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pieceBoard[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;

            pieces.put(i, new Piece(x, y, d));
            pieceBoard[x][y].add(i);  // 말 번호저장
        }

        int i = 1;
        for (; i <= 1000; i++) {
            // 1번 말부터 이동
            for (int j = 1; j <= pieces.size(); j++) {
                Piece piece = pieces.get(j);

                if(move(j, piece.x, piece.y, piece.d)) {
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean move(int j, int x, int y, int d) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        // 이동하려는 말 위의 말까지 분리
        int index = pieceBoard[x][y].indexOf(j);
        List<Integer> dividePieces = pieceBoard[x][y].subList(index, pieceBoard[x][y].size());

        if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == 2) {  // 이동하려는 칸이 체스판으로 벗어나거나 파란색인 경우
            int nd = (d % 2 == 0 ? d + 1 : d - 1);  // 방향 전환

            int nnx = x + dx[nd];
            int nny = y + dy[nd];

            // 반대 방향도 파란색인 경우 움직이지 않음
            if (nnx < 0 || nnx >= N || nny < 0 || nny >= N || board[nnx][nny] == 2) {
                pieces.put(j, new Piece(x, y, nd));
                return false;
            }

            // 체스말 map에 위치, 방향 변경
            pieces.put(j, new Piece(nnx, nny, nd));

            // 이동할 위치에 체스말 올리기
            if (board[nnx][nny] == 0){
                if (moveWhite(dividePieces, nnx, nny))
                    return true;
            } else if(board[nnx][nny] == 1) {
                if (moveRed(dividePieces, nnx, nny))
                    return true;
            }
        } else if (board[nx][ny] == 0) {  // 이동하려는 칸이 흰색인 경우
            if (moveWhite(dividePieces, nx, ny))
                return true;
        } else if (board[nx][ny] == 1) {  // 이동하려는 칸이 빨간색인 경우
            if (moveRed(dividePieces, nx, ny))
                return true;
        }

        int size = pieceBoard[x][y].size() - index;

        for (int i = 0; i < size; i++) {
            pieceBoard[x][y].remove(pieceBoard[x][y].size() - 1);
        }
        return false;
    }

    private static boolean moveWhite(List<Integer> dividePieces, int nx, int ny) {

        // 이동할 위치에 체스말 올리기
        pieceBoard[nx][ny].addAll(dividePieces);

        if (check(pieceBoard[nx][ny]))
            return true;

        // 체스말 map에 위치 변경
        for (Integer movedPiece : dividePieces) {
            pieces.get(movedPiece).x = nx;
            pieces.get(movedPiece).y = ny;
        }
        return false;
    }

    private static boolean moveRed(List<Integer> dividePieces, int nx, int ny) {
        // 옮길 체스말 순서 바꾸기
        Collections.reverse(dividePieces);

        // 이동할 위치에 체스말 올리기
        pieceBoard[nx][ny].addAll(dividePieces);

        if (check(pieceBoard[nx][ny]))
            return true;

        // 체스말 map에 위치 변경
        for (Integer movedPiece : dividePieces) {
            pieces.get(movedPiece).x = nx;
            pieces.get(movedPiece).y = ny;
        }
        return false;
    }

    private static boolean check(List<Integer> pieces) {
        return pieces.size() >= 4 ? true : false;
    }

    private static class Piece {
        int x, y, d;

        public Piece(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
