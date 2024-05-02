# Import random module
import random

# define functions for drawing numbers
def compu_draw():
  global compu_draw1
  compu_draw1 = []
  for i in range(3):
    while True:
      num1 = random.randint(-3, 3)
      if num1 != 0:
        compu_draw1 = compu_draw1 + [num1]
        break

def player_draw():
  global player_draw1
  player_draw1 = []
  for i in range(3):
    while True:
      num2 = random.randint(-3, 3)
      if num2 != 0:
        player_draw1 = player_draw1 + [num2]
        break

# define functions for drawing operations
def compu_operation():
  global compu_sum
  operation1 = random.choice(["+", "-", "*"])
  compu_sum = 0
  if operation1 == "+":
    for item in compu_draw1:
      compu_sum = compu_sum + item
  elif operation1 == "-":
    for item in compu_draw1:
      compu_sum = compu_sum - item
  elif operation1 == "*":
    compu_sum = 1
    for item in compu_draw1:
      compu_sum = compu_sum * item


def player_operation():
  global player_sum
  print("Here is your three numbers: " + str(player_draw1))
  while True:
    operation2 = input("Choose your operation (+ or - or *): ")
    player_sum = 0
    if operation2 == "+":
      for item in player_draw1:
        player_sum = player_sum + item
      break
    elif operation2 == "-":
      for item in player_draw1:
        player_sum = player_sum - item
      break
    elif operation2 == "*":
      player_sum = 1
      for item in player_draw1:
        player_sum = player_sum * item
      break
    else:
      print("Please enter either +, - or *.")
      pass
  print("Here is your sum: " + str(player_sum))

# define functions to combine the drawing and operation steps
def compu_hold():
  compu_draw()
  compu_operation()

def player_hold():
  player_draw()
  player_operation()

# define functions to reorder the numbers
def compu_order():
  random.shuffle(compu_list)

def player_order():
  global player_list1
  global player_list
  print("Here is your list of sums: " + str(player_list))
  player_list1 = []
  for i in range(5):
    while True:
      try:
        ordered_num = int(input("Please reorder your numbers, and enter the reordered numbers one by one after each colon : "))
      except ValueError:
        print("Please enter one number that is inside your list of sums!")
        continue
      exist = player_list.count(ordered_num)
      if exist > 0:
        player_list1 = player_list1 + [ordered_num]
        place = player_list.index(ordered_num)
        player_list = player_list[:place] + player_list[place + 1:]
        print("These sums left to be reordered: " + str(player_list))
        break
      else:
        print("Please enter one number that is inside your list of sums!")
        continue


# define a function for comparison and print the result
def final():

  #compare
  compu_points = 0
  player_points = 0

  for i in range(5):
    if compu_list[i] > player_list1[i]:
      compu_points = compu_points + 1
    elif player_list1[i] > compu_list[i]:
      player_points = player_points + 1

  # show player the numbers
  print("Computer's number: " + str(compu_list))
  print("Your numbers: " + str(player_list1))

  
  #display the result
  if player_points > compu_points:
    print("Congratulations! You win!")
    print("Your score: " + str(player_points))
    print("Computer's score: " + str(compu_points))
  elif player_points < compu_points:
    print("Unfortunately, you lose.")
    print("Your score: " + str(player_points))
    print("Computer's score: " + str(compu_points))
  else:
    print("Result: Tie")
    print("Your score: " + str(player_points))
    print("Computer's score: " + str(compu_points))

# game loop
while True:
  # ask the user to start the game or not
  question = input("Do you want to start the game? (start/exit) ")
  if question == "exit":
    break
  elif question == "start":
    pass
  else:
    print("Please enter either \"start\" or \"exit\".")
    continue

  # display the rules
  print("Rules for the game:")
  
  print(" 1. Both computer and you draw 3 numbers from 1, 2, -1, -2, -3 (may have duplicates).")

  print(" 2. You choose a mathematical operation from “ ＋, －, × ” to combine the 3 numbers together. \n The computer randomly draws an operation to combine the 3 numbers.")

  print(" 3. Repeat steps 1 & 2 five times to get 5 numbers for both participants.")

  print(" 4. You choose the order to show your numbers, and the computer randomly selects the order of its numbers. \n Compare the numbers from both sides in order, the larger number wins 1 point for its owner. ")

  print(" 5. Calculate the total points each participant has; the one with the more points wins.")

  # get 5 numbers

  # first number
  compu_hold()
  compu_sum1 = compu_sum

  player_hold()
  player_sum1 = player_sum

  # second number
  compu_hold()
  compu_sum2 = compu_sum

  player_hold()
  player_sum2 = player_sum

  # third  number
  compu_hold()
  compu_sum3 = compu_sum

  player_hold()
  player_sum3 = player_sum

  # forth number
  compu_hold()
  compu_sum4 = compu_sum

  player_hold()
  player_sum4 = player_sum

  # fifth number
  compu_hold()
  compu_sum5 = compu_sum

  player_hold()
  player_sum5 = player_sum

  # Combine all numbers into a list
  compu_list = []
  compu_list = [compu_sum1] + [compu_sum2] + [compu_sum3] + [compu_sum4] + [compu_sum5]

  player_list = []
  player_list = [player_sum1] + [player_sum2] + [player_sum3] + [player_sum4] + [player_sum5]

  # reorder the numbers
  compu_order()
  player_order()

  # final step: compare the number & show the result
  final()