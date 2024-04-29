class Naive extends Template {
    
    @Override
    protected boolean step1(String string, String substring)
    {
        int result = step2(string, substring);
        return result != -1;
    }

    private int step2(String string, String substring)
    {
        int stringLength = string.length();
        int subStringLength = substring.length();

        for (int i = 0; i <= stringLength - subStringLength; ++i)
        {
            int j = 0;
            while (j < subStringLength && string.charAt(i + j) == substring.charAt(j))
                ++j;
            if (j == subStringLength)
                return i;
        }

        return -1;
    }
}
