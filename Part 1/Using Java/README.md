## Overview
This part contains Java programs for my implementation of \
plotting, salting, and smoothing methods. \
EquationPlotter objects handle plotting, salting, and fixing data \
in the form of double arrays. It generates a csv file of the initial inputs \
and outputs by calling getCSV() after construction. It then can add new columns. \
It uses PrintWriters to write files and BufferedReaders to read them. 

## Contents: 
1. src code
2. CVS Equation One csv and xlsx
3. CVS Equation Two csv and xlsx
4. CVS Equation Three csv and xlsx

## Parameter Exploration:
1. Equation 1: f(x) = x^2 - 100x \
   ![image](https://github.com/user-attachments/assets/8d887b9f-c946-4a6f-bbd6-666f24dbd0c6) \

2. Equation 2: f(x) = x \
   ![image](https://github.com/user-attachments/assets/8cf2a6bd-5b75-492d-895f-0eaca29afb87) \

3. Equation 3: f(x) = 3x^3 - 3x \
   ![image](https://github.com/user-attachments/assets/845bf390-7643-497b-a9b1-94f757a269ea)


## Key takeaways:
1. APIs can make life easier
2. csv files are important to read and use

## References: 
1. https://www.geeksforgeeks.org/java-io-printwriter-class-java-set-1/
2. https://www.geeksforgeeks.org/java-io-bufferedreader-class-java/ (br.readLine())
3. https://www.geeksforgeeks.org/file-class-in-java/
4. https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html
5. https://www.digitalocean.com/community/tutorials/java-files-nio-files-class (Files .copy and .delete)


## Road Blocks:
1. Appending a row to a csv file:
     I had a hard time figuring this part out, but I learned a lot doing it. \
   I knew to find the last spot using BufferedReader and then print the relevant \
   values using a PrintWriter, but I found that I could not do that in the same CSV file. \
   This led me to make a temportary csv file to work with inside my method, which allowed me \
   to append a single row. However, I struggled to then append additional rows, as each\
   subsequent method call would overwrite the column. I did not push the temporary file changes \
   to the real one. I fixed this by using Files.copy to redirect the paths.


