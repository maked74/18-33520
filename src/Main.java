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

        for (int q = 1; q < N; q++)
        {
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                {
                    if (i + j == q)
                    {
                        if (i == 0)
                        {
                            dataSum[i][j] = dataSum[i][j - 1] + data[i][j];
                        }
                        else if (j == 0)
                        {
                            dataSum[i][j] = dataSum[i - 1][j] + data[i][j];
                        }
                        else
                        {
                            int vMax = Math.max(dataSum[i - 1][j], dataSum[i][j - 1]);
                            dataSum[i][j] = vMax + data[i][j];
                        }
                    }
                }
        }

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
