import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Message {
    public Message(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }

    int num;
    int idx;
}

class Frequency {
    public Frequency(int num, int count, int firstIndex) {
        this.num = num;
        this.count = count;
        this.firstIndex = firstIndex;
    }

    int num;
    int count;
    int firstIndex;
}

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();
        Message[] messages = new Message[N];
        for (int i = 0; i < N; i++)
            messages[i] = new Message(sc.nextInt(), i);

        Arrays.sort(messages, new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                return o1.num - o2.num;
            }
        });

        int uniqueCount = 1;
        for (int i = 1; i < N; i++)
            if (messages[i].num != messages[i - 1].num)
                uniqueCount++;

        Frequency[] frequencies = new Frequency[uniqueCount];
        frequencies[0] = new Frequency(messages[0].num, 1, messages[0].idx);
        int frequencyIndex = 0;
        for (int i = 1; i < N; i++) {
            if (messages[i].num != messages[i - 1].num)
                frequencies[++frequencyIndex] = new Frequency(messages[i].num, 0, messages[i].idx);
            frequencies[frequencyIndex].count++;
        }

        Arrays.sort(frequencies, new Comparator<Frequency>() {
            @Override
            public int compare(Frequency o1, Frequency o2) {
                if (o1.count == o2.count)
                    return o1.firstIndex - o2.firstIndex;
                return o2.count - o1.count;
            }
        });

        for (int i = 0; i < uniqueCount; i++)
            while (frequencies[i].count-- > 0)
                System.out.print(frequencies[i].num + " ");
        System.out.println();
    }
}
