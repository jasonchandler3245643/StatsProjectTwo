
% Set the original inputs and outputs
x = 0:100;
y =  x.^2 - x*100 ;

% Plot the original graph
figure('Name', 'Original Graph', 'NumberTitle', 'off'); % Title the graph's window
plot(x, y, 'c-', 'LineWidth', 2); % plot y for each x with magenta line of width 2
xlabel('Input (x)'); % Label the x axis
ylabel('Output (f(x))'); % Label the y-axis
title('Graph of f(x) = x^2 - 100x'); % Title the graph
grid on; % Show the grid


% Salt the outputs
random_values = randi([1000,2000], size(y)); % make vector of same size as y made of random values
salted_y = y + random_values; % add the randm values to y

% Plot the salted graph
figure('Name', 'Salted Graph', 'NumberTitle', 'off');
plot(x, salted_y, 'p-', 'LineWidth', 2); % I wanted purple, but the -p is interesting
xlabel('Input (x)');
ylabel('Output (f(x) + random salt value)');
title('Graph of f(x) salted');
grid on;



% Fix the outputs
average_range = 3; % set the window
smoothed_y = movmean(salted_y, average_range); % smooth it
smoothed_twice_y = movmean(smoothed_y, average_range);
smoothed_thrice_y = movmean(smoothed_twice_y, average_range);

% Plot the fixed graph
figure('Name', 'Fixed Graph', 'NumberTitle', 'off');
plot(x, salted_y, 'g-', 'LineWidth', 2); % plot it salted
hold on; % tell Octave to wait for more lines
plot(x, smoothed_y, 'r-', 'LineWidth', 2); % Plot it smoothed once
plot(x, smoothed_twice_y, 'y-', 'LineWidth', 2);
plot(x, smoothed_thrice_y, 'b-', 'LineWidth', 2);

xlabel('Input (x)');
ylabel('Output)');
title('Graph of f(x) fixed three times');
grid on;



