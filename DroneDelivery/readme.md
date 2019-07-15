# Drone Delivery Challenge

The goal is to implement an algorithm to schedule drone-carried deliveries. 

## Given Factors

1. The town is organized in a perfect grid with the warehouse and drone-launch facility at the center. 
2. .All deliveries originate at the warehouse and are carried by a drone to a customer location.
3.  A drone's "ground speed" is exactly one horizontal or vertical grid block per minute.
4.  Net Promoter Score (NPS) is defined as the percentage of promoters minus the percentage of detractors.
5. ￼ If the order is delivered in one hour or less from the order placement timestamp, we can consider those orders do be in the promotor zone.
6. If the order is delivered within two or three hours from the order placement timestamp, we consider those orders to be in the neutral zone
7. If the order is delivered after four hours (till upto 10 hours) from order placement timestamp, we consider those orders to be in the detractor zone.  
6. There is only one drone.
7. Drone operation hours are from 6 a.m. until 10 p.m.

## Design

The above factors are taken into the design of the system.

### Modularity

The code is broken down into modules which run their function and return an ouput. 
1. testdronefunction(input_path): This is the driving function which takes the file path as input and returns the output.txt file path as output. It imports the other functions and applies it to the input file to calculate the delivery time and NPS. 
2. adddistancetoschedule(delivery_schedule_dictionary_input): This module calculates the distance for every input by importing the distance calculator function and appending the result to the dictionary value. It returns the dictionary with the distance appended.
3.  distancecalculator(y_coordinate_input, x_coordinate_input): This function takes the y and x coordinates of the dictionary from adddistancetoschedule() and returns the Manhattan Distance.
4. calcorderdeliverytime(delivery_schedule_dictionary_input, start_time_input, end_time_input): This function takes the drone start and end time and runs the program till the the end time specified.  It imports prioritycalculator the calc_priority() to get the priority of the orders.It stores the start time as end_time variable and updates it according to its order priority and timestamp. It calculates the delivery time for each order using the distance stored in the dictionary and updates the start time(next_time variable) to when the drone would return to the facility.  It returns the delivery schedule dictionary with the delivery time appended. 
5. prioritycalculator(delivery_schedule_dictionary_input): It calculates the priority of each order.
6. convertdictionaryvalues(dictionary_values_as_input):  It converts the .txt file into a dictionary. It makes the order number as the dictionary key. The coordinates are converted to y and x. The timestamps are converted to python date format. These are added to the dictionary value as a list. A datetime variable calculating the time one hour ahead of order placement is added to the list.

### Distance

Since there are four directions of motion in a grid (North, South, East and West), I have used Manhattan Distance to calculate the distance from the Origin(warehouse) and the order coordinates. 
Initially, I was using Euclidean Distance to measure distance, but since the degree of motion is limited, I switched to Manhattan Distance to calculate the distance. 




## Terminal Commands to Deploy the Code

The main file that executes the algorithm is testdronefunction.py
To execute this in the terminal, the following steps are required:

Starting python shell

```
python

```
Importing testdronefunction.py 

```
import testdronefunction as tdf

```
Input command for to input the file

```
tdf.drone_delivery("file_path")

```
The output path is returned. Exit the python shell.

```
exit()

```
Reading the output file

```
chmod -r file_path

```
```
cat file_path

```
These two commands enable the output to be displayed.

### Testing 

Command to start the testing module

```
python testingmodule.py -v
```
-v (verbose): displays the output of the testing module in the terminal




## Authors

**Upasana Pattnaik**

