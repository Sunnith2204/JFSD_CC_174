import random

def start_game():
    print("🌌 Welcome to the Terminal Adventure Game! 🌌")
    print("You are a space explorer venturing into an unknown galaxy.")
    print("Your mission: Survive and return safely to your home planet.")
    print("-" * 50)
    health = 10
    inventory = []

    while True:
        print("\nWhere would you like to go?")
        print("1. Explore the mysterious planet 🌍")
        print("2. Enter the dark space station 🛰️")
        print("3. Return to your spaceship 🚀 (Exit Game)")

        choice = input("Enter 1, 2, or 3: ")

        if choice == "1":
            print("\nYou land on the planet. The air is breathable.")
            print("A strange alien approaches...")
            action = input("Do you (a) talk to it or (b) attack it? ")

            if action == "a":
                print("The alien is friendly and gives you a healing herb! +2 health")
                health += 2
                inventory.append("Healing Herb")
            elif action == "b":
                print("The alien fights back! You lose 3 health.")
                health -= 3
            else:
                print("You hesitated... the alien leaves.")

        elif choice == "2":
            print("\nInside the space station, it’s dark and cold...")
            event = random.choice(["enemy", "treasure", "nothing"])

            if event == "enemy":
                print("A rogue robot attacks! You lose 2 health.")
                health -= 2
            elif event == "treasure":
                print("You found a plasma sword! ⚔️")
                inventory.append("Plasma Sword")
            else:
                print("You found nothing but dust...")
        elif choice == "3":
            print("\nYou return to your spaceship...")
            print("Mission Complete!")
            break
        else:
            print("Invalid choice. Try again.")
        if health <= 0:
            print("\n💀 You’ve run out of health. Game Over!")
            break
        print(f"❤️ Health: {health}")
        print(f"🎒 Inventory: {inventory}")
if __name__ == "__main__":
    start_game()
