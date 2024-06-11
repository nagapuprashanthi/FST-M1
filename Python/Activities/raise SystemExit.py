count = 0;
 
while count < 5:
    choice = input("Enter a choice from 1 to 4: ")
    if choice == "1":
        print("You picked 1")
    elif choice == "2":
        print("Quitting program")
        raise SystemExit
    elif choice == "3":
        print("You picked choice 3")
    elif choice == "4":
        print("You picked 4!")
    else:
        print("You picked something else")
    print(f"Number of choices remaining: {5 - count}")
    count = count + 1
 