# Cathay Li - Assignment #6
# Input: N/A
# Processing: N/A
# Output: Animation

import pygame
import time
from pygame.locals import *

pygame.init()
pygame.mixer.init()
surface = pygame.display.set_mode([900, 600])
pygame.display.set_caption("BasketBall - Cathay Li")
myFont1 = pygame.font.SysFont("gabriola", 60)
myFont2 = pygame.font.SysFont("gabriola", 20)
A1 = pygame.image.load("A1.png")
A2 = pygame.image.load("A2.png")
A3 = pygame.image.load("A3.png")
A4 = pygame.image.load("A4.png")
A5 = pygame.image.load("A5.png")
A6 = pygame.image.load("A6.png")
J1 = pygame.image.load("J1.png")
J2 = pygame.image.load("J2.png")
J3 = pygame.image.load("J3.png")
J4 = pygame.image.load("J4.png")
B = pygame.image.load("B.png")
JA = pygame.image.load("J&A.png")
musicFile1 = pygame.mixer.Sound("Happy.wav")
musicFile2 = pygame.mixer.Sound("Earthquake.wav")
musicFile3 = pygame.mixer.Sound("Hope.wav")
musicFile4 = pygame.mixer.Sound("Astral.wav")
musicFile5 = pygame.mixer.Sound("Count on me.wav")
scene = 1
white = (255, 255, 255)
black = (0, 0, 0)
brown = (61, 12, 2)
orange = (255, 165, 0)
yellow = (255, 255, 102)
changeX = 0
elapsedTime = 0
clock = pygame.time.Clock()

pygame.mixer.Channel(1).set_volume(0.5)
pygame.mixer.Channel(2).set_volume(1.0)

while True:
    event = pygame.event.poll()
    if event.type == pygame.QUIT:
        break
    elif event.type == KEYDOWN and event.key == K_ESCAPE:
        break

    delayTime = clock.tick()
    elapsedTime = elapsedTime + delayTime

    if 3000 < elapsedTime < 4500:
        words1 = myFont1.render("J: Hi Alex!", 1, orange)
        words1X = 450
        words1Y = 270
    elif 4500 < elapsedTime < 6000:
        words1 = myFont1.render("A: Hi James!", 1, brown)
        words1X = 250
        words1Y = 270
    elif 6050 < elapsedTime < 7500:
        words1 = myFont1.render("J: Wanna play basketball?", 1, orange)
        words1X = 300
        words1Y = 200
    elif 7500 < elapsedTime < 8500:
        words1 = myFont1.render("A: Sure.", 1, brown)
        words1X = 200
        words1Y = 200
    elif 14800 < elapsedTime < 16000:
        words1 = myFont1.render("A: Ha! One point for myself.", 1, brown)
        words1X = 100
        words1Y = 200
    elif scene == 4 and 16000 < elapsedTime:
        words1 = myFont1.render("J: I will beat you with the next ball!", 1, orange)
        words1X = 150
        words1Y = 200
    elif scene == 5 and 24000 > elapsedTime > 22800:
        words1 = myFont1.render("J: See? I beat you!", 1, orange)
        words1X = 150
        words1Y = 200
    elif scene == 5 and elapsedTime > 24000:
        words1 = myFont1.render("A: Ah!", 1, brown)
        words1X = 500
        words1Y = 200
    elif scene == 6 and img2X < 300:
        words1 = myFont1.render("J: I am sorry!", 1, orange)
        words1X = 150
        words1Y = 200
    elif scene == 6 and img2X == 300:
        words1 = myFont1.render("A: That's fine, don't worry about it.", 1, brown)
        words1X = 150
        words1Y = 200
    elif scene == 7 and elapsedTime < 29000:
        words1 = myFont1.render("J: Let me wrap it for you!", 1, orange)
        words1X = 150
        words1Y = 200
    elif scene == 7 and elapsedTime > 29000:
        words1 = myFont1.render("A: Thanks, my friend!", 1, brown)
        words1X = 400
        words1Y = 200

    if scene == 1:
        backColour = black
        pygame.mixer.Channel(1).play(musicFile1)
        words1 = myFont1.render("Basketball", 1, white)
        words1X = 350
        words1Y = 270
        words2 = myFont2.render("By: Cathay Li", 1, white)
        words2X = 600
        words2Y = 200
    elif scene == 2:
        backColour = white
        img1 = pygame.transform.scale(A1, [200, 200])
        img1X = -100 + changeX
        img1Y = 375
        img2 = pygame.transform.scale(J1, [200, 200])
        img2X = 800 - changeX
        img2Y = 375
        changeX = changeX + 1
    elif scene == 3:
        backColour = white
        pygame.mixer.Channel(1).stop()
        pygame.mixer.Channel(2).play(musicFile2)
        img1X = 200 - changeX
        img1Y = 200 - changeX
        img0 = pygame.transform.flip(JA, True, False)
        img1 = pygame.transform.scale(img0, [img1X, img1Y])
        img2 = pygame.transform.flip(B, True, False)
        img3 = pygame.transform.scale(img2, [200, 200])
        img4 = pygame.transform.scale(B, [200, 200])
        changeX = changeX + 1
        time.sleep(0.15)
    elif scene == 4:   # This scene may has a problem with the "time", try several time and you MAY see ( or it's just my computer's problem)
        backColour = white      # the "time" means the clock.tick (elapsedTime) is not the same everytime
        pygame.mixer.Channel(2).stop()
        pygame.mixer.Channel(2).play(musicFile3)
        img0 = pygame.transform.flip(A2, True, False)
        img1 = pygame.transform.scale(img0, [200, 200])
        img3 = pygame.transform.scale(J2, [200, 200])
        if elapsedTime < 12750:
            img1X = 50 + changeX
        else:
            img1X = img1X
        img1Y = 370
        changeX = changeX + 2
        if 11450 > elapsedTime:
            img2X = 650 - changeX
        elif 12750 > elapsedTime > 11450:
            img2X = img2X + 2
        else:
            img2X = img2X
        img2Y = 370
        if 567 > circleY >= 540 and elapsedTime < 12650:
            circleY = circleY + 1
        elif circleY == 567 and elapsedTime < 12650:
            circleY = 540
        elif 14830 > elapsedTime >= 12650:
            circleY = circleY - 3
        elif circleY >= 200 or circleY < 200:
            circleY = circleY + 2.5
        img4 = pygame.transform.scale(A3, [200, 200])
    elif scene == 5:  # This scene may has a problem with the "time", try several time and you MAY see ( or it's just my computer's problem)
        backColour = white  # the "time" means the clock.tick (elapsedTime) is not the same everytime
        pygame.mixer.Channel(2).stop()
        pygame.mixer.Channel(2).play(musicFile4)
        if img1X < 350:
            img1X = 50 + changeX
            circleX = 160 + changeX
        else:
            img1X = img1X
            circleX = 425 - change2X
            change2X = change2X + 2
        img1Y = 370
        changeX = changeX + 2
        if img2X > 150:
            img2X = 650 - changeX
        elif img2X <= 150:
            img2X = img2X
        img2Y = 370
        img5 = pygame.transform.scale(A4, [200, 200])
        if 560 > circleY >= 530 and elapsedTime < 21500:
            circleY = circleY + 1
        elif circleY >= 560 and elapsedTime < 21500:
            circleY = 530
        elif 23280 > elapsedTime >= 21500:
            circleY = circleY - 4
            circleX = circleX - 1
        elif circleY >= 250 or circleY < 250:
            circleY = circleY + 5
        img4 = pygame.transform.flip(J3, True, False)
        img6 = pygame.transform.scale(img4, [200, 200])
    elif scene == 6:
        backColour = white
        pygame.mixer.Channel(2).stop()
        pygame.mixer.Channel(1).play(musicFile5)
        img1X = 350
        img1Y = 370
        changeX = changeX + 2
        if img2X < 300:
            img2X = 150 + changeX
        elif img2X >= 300:
            img2X = img2X
        img2Y = 425
        img1 = pygame.transform.flip(J1, True, False)
        img3 = pygame.transform.scale(img1, [150, 150])
        img4 = pygame.transform.flip(A5, True, False)
        img5 = pygame.transform.scale(img4, [200, 200])
    elif scene ==7:
        backColour = yellow
        img1X = 350
        img1Y = 370
        img2X = 345
        img2Y = 400
        img0 = pygame.transform.flip(J4, True, False)
        img6 = pygame.transform.scale(img0, [200, 200])
        img7 = pygame.transform.flip(A6, True, False)
        img8 = pygame.transform.scale(img7, [200, 200])
        img1 = pygame.transform.flip(A5, True, False)
        img3 = pygame.transform.scale(img1, [200, 200])
    elif scene == 8:
        backColour = black
        words1 = myFont1.render("The End", 1, white)
        words1X = 375
        words1Y = 270

    surface.fill(backColour)
    if scene == 1 or scene == 2:
        surface.blit(words1, [words1X, words1Y])
        surface.blit(words2, [words2X, words2Y])
    elif scene == 3 and 6050 < elapsedTime < 8500:
        surface.blit(words1, [words1X, words1Y])
    elif scene == 4 and elapsedTime > 14800:
        surface.blit(words1, [words1X, words1Y])
    elif scene == 5 and elapsedTime > 22800:
        surface.blit(words1, [words1X, words1Y])
    elif scene == 6 or scene == 7 or scene == 8:
        surface.blit(words1, [words1X, words1Y])

    if scene == 2 and backColour == white:
        surface.blit(img1, [img1X, img1Y])
        surface.blit(img2, [img2X, img2Y])
        pygame.draw.line(surface, black, [0, 570], [900, 570], 4)
    elif scene == 3 and backColour == white:
        pygame.draw.polygon(surface, black, ([360, 530], [345, 570], [550, 570], [505, 530]), 4)
        surface.blit(img3, [50, 300])
        surface.blit(img4, [650, 300])
        surface.blit(img1, [350, 380])
    elif scene == 4 and backColour == white and elapsedTime < 12750:
        pygame.draw.line(surface, black, [0, 570], [900, 570], 4)
        surface.blit(img2, [0, 200])
        surface.blit(B, [500, 200])
        surface.blit(img1, [img1X, img1Y])
        surface.blit(img3, [img2X, img2Y])
        pygame.draw.circle(surface, orange, [160 + changeX, circleY], 10, 0)
    elif scene == 4 and 13100 > elapsedTime > 12750:
        pygame.draw.line(surface, black, [0, 570], [900, 570], 4)
        surface.blit(img2, [0, 200])
        surface.blit(B, [500, 200])
        surface.blit(img4, [img1X, img1Y])
        surface.blit(img3, [img2X, img2Y])
        pygame.draw.circle(surface, orange, [160 + changeX, circleY], 10, 0)
    elif scene == 4 and elapsedTime > 13100:
        pygame.draw.line(surface, black, [0, 570], [900, 570], 4)
        surface.blit(img2, [0, 200])
        surface.blit(B, [500, 200])
        surface.blit(img1, [img1X, img1Y])
        surface.blit(img3, [img2X, img2Y])
        pygame.draw.circle(surface, orange, [160 + changeX, circleY], 10, 0)
    elif scene == 5 and img1X < 350:
        pygame.draw.line(surface, black, [0, 570], [900, 570], 4)
        surface.blit(img2, [0, 200])
        surface.blit(B, [500, 200])
        surface.blit(img1, [img1X, img1Y])
        surface.blit(img3, [img2X, img2Y])
        pygame.draw.circle(surface, orange, [circleX, circleY], 10, 0)
    elif scene == 5 and img1X >= 350 and elapsedTime < 21500:
        pygame.draw.line(surface, black, [0, 570], [900, 570], 4)
        surface.blit(img2, [0, 200])
        surface.blit(B, [500, 200])
        surface.blit(img5, [img1X, 410])
        surface.blit(img3, [img2X, img2Y])
        pygame.draw.circle(surface, orange, [circleX, circleY], 10, 0)
    elif scene == 5 and 22600 > elapsedTime >= 21500:
        pygame.draw.line(surface, black, [0, 570], [900, 570], 4)
        surface.blit(img2, [0, 200])
        surface.blit(B, [500, 200])
        surface.blit(img5, [img1X, 410])
        surface.blit(img6, [img2X, img2Y])
        pygame.draw.circle(surface, orange, [circleX, circleY], 10, 0)
    elif scene == 5 and elapsedTime > 22600:
        pygame.draw.line(surface, black, [0, 570], [900, 570], 4)
        surface.blit(img2, [0, 200])
        surface.blit(B, [500, 200])
        surface.blit(img5, [img1X, 410])
        surface.blit(img3, [img2X, img2Y])
        pygame.draw.circle(surface, orange, [circleX, circleY], 10, 0)
    elif scene == 6:
        pygame.draw.line(surface, black, [0, 570], [900, 570], 4)
        surface.blit(img2, [0, 200])
        surface.blit(B, [500, 200])
        surface.blit(img5, [img1X, 410])
        surface.blit(img3, [img2X, img2Y])
    elif scene == 7 and elapsedTime <= 29000:
        pygame.draw.line(surface, black, [0, 570], [900, 570], 4)
        surface.blit(img2, [0, 200])
        surface.blit(B, [500, 200])
        surface.blit(img3, [img1X, 410])
        pygame.draw.polygon(surface, white, ([455, 530], [465, 530], [475, 545], [465, 545]), 0)
        pygame.draw.polygon(surface, black, ([455, 530], [465, 530], [475, 545], [465, 545]), 2)
        surface.blit(img6, [img2X, img2Y])
    elif scene == 7 and elapsedTime > 29000:
        pygame.draw.line(surface, black, [0, 570], [900, 570], 4)
        surface.blit(img2, [0, 200])
        surface.blit(B, [500, 200])
        surface.blit(img8, [img1X, 410])
        pygame.draw.polygon(surface, white, ([455, 530], [465, 530], [475, 545], [465, 545]), 0)
        pygame.draw.polygon(surface, black, ([455, 530], [465, 530], [475, 545], [465, 545]), 2)
        surface.blit(img6, [img2X, img2Y])

    pygame.display.update()
    pygame.display.flip()

    if scene == 1:
        time.sleep(3)
        scene = 2
    elif scene == 2 and img2X == 400:
        scene = 3
        changeX = 0
    elif scene == 3 and elapsedTime > 8500:
        scene = 4
        changeX = 0
        circleY = 540
    elif scene == 4 and elapsedTime > 17000:
        scene = 5
        changeX = 0
        change2X = 0
        img1X = 50
    elif scene == 5 and elapsedTime > 24900:
        scene = 6
        changeX = 0
    elif scene == 6 and elapsedTime > 27200:
        scene = 7
    elif scene == 7 and elapsedTime > 31000:
        scene = 8
    elif scene == 8:
        time.sleep(3)
        pygame.mixer.Channel(1).stop()
        scene = 1
        changeX = 0
        elapsedTime = 0
        clock = pygame.time.Clock()

pygame.display.quit()
quit()
