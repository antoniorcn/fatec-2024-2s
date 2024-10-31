import pygame
from pygame.locals import QUIT
from random import randint

pygame.init()

screen = pygame.display.set_mode((1280, 1024), 0, 32)

while True:
    # Calcular regras

    # Atualizar tela
    screen.fill( (0, 0, 0) )
    for i in range(1000):
        # Sortear valores para a posicao
        x = randint(0, 1280)
        y = randint(0, 1024)
        r = randint(0, 255)
        g = randint(0, 255)
        b = randint(0, 255)
        raio = randint(0, 300)
        # screen.set_at( (x, y), (255, 255, 0) )
        pygame.draw.circle( screen, 
                           center=(x, y), 
                           color=(r, g, b), 
                           radius=r,
                           width=6 )

    pygame.display.update()

    for event in pygame.event.get():
        if event.type == QUIT:
            exit()