N = int(input())
cards = {}
for card in list(input().split()):
    if card not in cards:
        cards[card] = 0
    cards[card] += 1

M = int(input())
print(' '.join(str(cards.get(card, 0)) for card in input().split()))
