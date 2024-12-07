% Learn the basics

% Display in command window first
disp('Love free software');
disp(123);

% ints, doubles, and strings are treated like in python:
int = 455432;
double = 32.4325346;
string = "fsd";

% Display multiple on same command line
% I need to make them all strings for this to work
% otherwise, warning: implicit conversion from numeric to char
disp([num2str(int) , ' ', num2str(double), ' ', string]);

% There are row and column vectors
a = [1, 2, 3]; % holds 1, 2, and 3 like ypical Java array

% Column vectors are matrixed with 1 columns
b = [4; 5; 6];

% Matrixes are like simple 2D arrays:
matrixExample = [1, 2, 3; 4, 5, 6; 7, 8, 9];

% Lets see them:
disp(a);
disp(b);
disp(matrixExample);

% Plotting is important in Octave

% Get data to plot
x = 0:50; % x is row vector with 0 - 100
y = 20 * x;
otherOutput = x .^ 2;

% Make a figure and plot the data in it
figure('Name', 'plot basics', 'NumberTitle', 'off');
plot(x, y); % plot x against y
hold on; % TELL OCTAVE TO WAIT!!
plot (x, otherOutput);

% Format the figure
xlabel('Input (x)'); % label it
ylabel('Outputs');
grid on; % show the grid lines
legend('50x', 'x^2'); % make a legend. It labels the line in order of plotting;

% Plot in 3D:

% Make grid
[xx, yy] = meshgrid(-5:5, -5:5); % Make a 3D grid of values xx and yy defined
zz = xx .^ 2 + yy .^ 2; % The operators need the .
figure;
surf(xx, yy, zz); % plot zz as a surface. Mesh works for a mesh
colormap(spring);
colorbar;
xlabel('X-axis');
ylabel('Y-axis');
zlabel('Z-axis');

% Try salting:
randomNums = randi([-200,200], size(y)); % x random integers
salted = y + randomNums;

% Try smoothing with simple vector averaging
smoothed = (salted + y) / 2;

% Alternatively, use movmean
smoothedMov = movmean(salted, 5); % average current and two neighbors

figure('Name', 'salt smooth', 'NumberTitle', 'off');
plot(x, y, 'red');
hold on;
plot(x, salted, 'green');
plot(x, smoothed, 'cyan');
plot(x, smoothedMov, 'blue');
legend('original', 'salted', 'smoothed with average', 'smoothed moving average once');
