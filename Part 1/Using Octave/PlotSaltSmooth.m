% Set the original inputs and outputs
x = 0:100;
y =  x.^2 - x*100 ;

% Salt the outputs
random_values = randi([-1000,1000], size(y)); % make vector of same size as y made of random values
salted_y = y + random_values; % add the randm values to y

% Fix the outputs
average_range = 5; % set the window
smoothed_y = movmean(salted_y, average_range); % smooth it
smoothed_twice_y = movmean(smoothed_y, average_range);
smoothed_thrice_y = movmean(smoothed_twice_y, average_range);

% Plot the fixed graph
figure('Name', '2D plotted, salted, and smoothed', 'NumberTitle', 'off');
plot(x, salted_y, 'p-', 'LineWidth', 2); % plot it salted
hold on; % tell Octave to wait for more lines
plot(x, smoothed_y, 'g-', 'LineWidth', 2); % Plot it smoothed once
plot(x, smoothed_thrice_y, 'r-', 'LineWidth', 2);
plot(x, y, 'm-', 'LineWidth', 2); % plot y for each x with magenta line of width 2

legend('salted', 'smoothed once', 'smoothed thrice', 'original');
xlabel('Input (x)');
ylabel('Output');
grid on;


% lets try in 3D!

a = b = linspace (-20, 20, 40); % a and b are vectors from -20 to 20
[A, B] = meshgrid(a, b);

C = (A.^2 + B.^2) / (4);

figure('Name', 'Normal 3D', 'NumberTitle', 'off');
colormap('hot')
surf(A, B, C, 'EdgeColor', 'none'); % Plot it as a surface
xlabel('X-axis');
ylabel('Y-axis');
zlabel('Z-axis');


% Now lets mess it up
random_values = randi([-100, 100], size(C));
salty_C = C + random_values;

% Plot in 3D
figure('Name', '3D plotted, salted, and smoothed', 'NumberTitle', 'off');
surf(A, B, C, 'EdgeColor', 'none', 'FaceColor', 'red'); % Plot it as a surface
hold on;
saltedMesh = mesh(A, B, salty_C, 'EdgeColor', 'green'); % store the mesh plot
set(saltedMesh, 'FaceAlpha', 0);

% Lets smooth it 3 times
average_range = 5;
smoothed_C = movmean(salty_C, average_range);
smoothed_twice_C = movmean(smoothed_C, average_range);
smoothed_thrice_C = movmean(smoothed_twice_C, average_range)

% Now lets plot it against the original and salted
twiceSmoothedMesh = mesh(A, B, smoothed_thrice_C, 'EdgeColor', 'black');
set(twiceSmoothedMesh, 'FaceAlpha', 0);
legend('original', 'salted', 'smoothed twice');
xlabel('X-axis');
ylabel('Y-axis');
zlabel('Z-axis');

% That works! Lets look at a different 3D surface,
% as the visualization is not the best

% Get the vecotrs
C = (1000 ./ (3 + A.^2 + B.^2));
random_values = randi([0, 100], size(C));
salty_C = C + random_values;
smoothed_twice_C = movmean(movmean(salty_C, average_range), average_range);
smoothed_thrice_C = movmean(smoothed_twice_C, average_range);


% Plot them in 3D
figure('Name', '3D Better Visualization', 'NumberTitle', 'off');
surf(A, B, C, 'EdgeColor', 'black');
hold on;
tallMesh = mesh(A, B, salty_C, 'EdgeColor', 'green');
smoothed = mesh(A, B, smoothed_thrice_C, 'EdgeColor', 'red');
set(tallMesh, 'FaceAlpha', 0);
set(smoothed, 'FaceAlpha', 0);
xlabel('X-axis');
ylabel('Y-axis');
zlabel('Z-axis');



