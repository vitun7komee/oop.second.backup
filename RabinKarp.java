import java.util.ArrayList;

class RabinKarp extends Template {

    @Override
    protected boolean step1(String string, String substring)
    {
        ArrayList<Integer> prefixResult = step2(string, substring);
        //System.out.println(prefixResult);
        return !prefixResult.isEmpty();
    }

    private ArrayList<Integer> step2(String string, String substring) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        final int alphabetSize = 256;
        final int mod = 9973;

        int substringHash = ((int) substring.charAt(0)) % mod;
        int stringHash = ((int) string.charAt(0)) % mod;

        int firstIndexHash = 1;

        for (int i = 1; i < substring.length(); i++)
        {
            substringHash *= alphabetSize;
            substringHash += (int)substring.charAt(i);
            substringHash %= mod;

            stringHash *= alphabetSize;
            stringHash += (int)string.charAt(i);
            stringHash %= mod;

            firstIndexHash *= alphabetSize;
            firstIndexHash %= mod;
        }

        for (int i = 0; i <= string.length() - substring.length(); i++)
        {
            if (substringHash == stringHash && step3(string, i, substring))
                result.add(i);

            if (i != string.length() - substring.length())
            {
                stringHash -= (((int)string.charAt(i)) * firstIndexHash) % mod;
                stringHash += mod;
                stringHash *= alphabetSize;
                stringHash += (int)string.charAt(i + substring.length());
                stringHash %= mod;
            }
        }

        return result;
    }

    boolean step3(String string, int index, String substring)
    {
        for (int i = 0; i < substring.length(); i++)
            if (substring.charAt(i) != string.charAt(index + i))
                return false;
        return true;
    }
}
