//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main()
{
    try (BufferedReader br = new BufferedReader(new FileReader("18.txt")))
    {
        int N = 15;
        int[][] data = new int[N][N];
        String line;
        int k = 0;
        while ((line = br.readLine()) != null)  // читаем файл построчно и заполняем массив
        {
            String[] strArr = line.split("\t");
            for (int i = 0; i < N; i++)
            {
                data[k][i] = Integer.parseInt(strArr[i]);
            }
            k++;
        }

        IO.println("---------------------------------------");
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
            {
                if(j == N - 1)
                {
                    IO.println(data[i][j]);
                }
                else
                {
                    IO.print(data[i][j]);
                    IO.print(" ");
                }
            }

        int[][] dataSum = new int[N][N];
        dataSum[0][0] = data[0][0];

        int vMax = data[0][0];
        for (int i = 1; i < N; i++)
        {
            dataSum[i][0] = vMax + data[i][0];
            vMax = Math.max(vMax,dataSum[i][0]);
        }

        vMax = data[0][0];
        for (int i = 1; i < N; i++)
        {
            dataSum[0][i] = vMax + data[0][i];
            vMax = Math.max(vMax,dataSum[0][i]);
        }

        int[] vMaxUp = new int[N];
        System.arraycopy(dataSum[0], 0, vMaxUp, 0, N);

        for (int i = 1; i < N; i++)
        {
            int vMaxLeft = dataSum[i][0];
            for (int j = 1; j < N; j++)
            {
                 vMax = Math.max(vMaxLeft, vMaxUp[i]);
                 dataSum[i][j] = vMax + data[i][j];
                 vMaxUp[i] = Math.max(vMaxUp[i], dataSum[i][j]);
            }
        }


        IO.println("---------------------------------------");
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
            {
                if(j == N - 1)
                {
                    IO.println(dataSum[i][j]);
                }
                else
                {
                    IO.print(dataSum[i][j]);
                    IO.print(" ");
                }
            }

    }
    catch (IOException e)
    {
        IO.println(e.getMessage());
    }
}
