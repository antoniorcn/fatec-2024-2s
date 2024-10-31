import pygame
from pygame.locals import QUIT

pygame.init()


screen = pygame.display.set_mode((800, 600), 0, 32)

while True:
    # Calcular regras

    # Pintar a tela

    screen.fill( (0, 0, 0) )

    pygame.draw.ellipse(screen, (255, 255, 0), 
                        ( (100, 150), (200, 50) ),
                        5 )
    
    pygame.display.update()

    # Capturar eventos
    for event in pygame.event.get():
        if event.type == QUIT:
            exit()

