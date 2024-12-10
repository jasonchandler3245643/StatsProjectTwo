# Using Java APIs

The program uses Apache POI to plot and graph in excel, \
Apache Commons Math for salting and smoothing.

# Content:
1. Java src code
2. pom.xml
3. The Excels: folder with all 6 excel files

## Graph Examples
Each has a graph with Guissan salt and then Normal salt \
1. Equation 1: f(x) = 10x
   
 ![Linear Guissan](https://github.com/user-attachments/assets/d8298e9a-0692-4650-8d47-344dc11f0291)
![Linear Uniform](https://github.com/user-attachments/assets/9cd526e6-714b-4bd5-8381-5fe485a3eaee)
   
3. Equation 2: f(x) = x^2 - 100x
![Square Guissan](https://github.com/user-attachments/assets/b5d9dec4-aa76-441a-a4e3-e6f0179f3c5b)
![Square Uniform](https://github.com/user-attachments/assets/e369ab1b-ce91-48ac-8eaf-0369c30ca3da)

4. Equation 3: f(x) = 3x^3 - 3x
![Cubic Guissan](https://github.com/user-attachments/assets/fab963c2-de91-4222-bcc3-5c35cc063b88)
![Cubic Uniform](https://github.com/user-attachments/assets/9adbf9d3-9f10-4ece-a7c5-b0a6f511575d)

## Normal vs Guissan salt: 
 Both are accessed using Apache RandomDataGenerator and generate random numbers \ 
 from a lower to upper bound. However, the distribution of these numbers are not the same: \
 Guissan salt values are follow a bell curve, whereas normal follows normal distribution. \
 Above, the Guissan are first and the Normal are second. \ Based on those graphs, \
 I conclude that Guissan salt messes up the data more, as if clearly has jags spiking out 
 of its graphs, especially in the center of Equation 2.

## References:
1. 
2. https://poi.apache.org/components/spreadsheet/quick-guide.html !!
3. https://github.com/dearshor/poiexamples/blob/master/src/main/java/poi/xssf/usermodel/examples/LineChart.java
4.  https://github.com/ashrawan/apache-poi-chart-sample
5.  https://www.e-iceblue.com/Tutorials/Java/Spire.XLS-for-Java/Program-Guide/Chart/Java-Create-a-Line-Chart-in-Excel.html
