import pygame
from pygame.locals import QUIT

pygame.init()


screen = pygame.display.set_mode((1280, 1024), 0, 32)

while True:
    # Calcular regras

    # Pintar a tela

    screen.fill( (0, 0, 0) )

    for i in range(6):
        y = (i * 50)
        height = 600 - (100 * i)
        pygame.draw.ellipse(screen, (255, 255, 0), 
                            ( (0, y), (600, height) ),
                            5 )
        
    for i in range(6):
        x = (i * 50)
        width = 600 - (100 * i)
        pygame.draw.ellipse(screen, (255, 255, 0), 
                            ( (x, 0), (width, 600) ),
                            5 )        
    
    pygame.display.update()

    # Capturar eventos
    for event in pygame.event.get():
        if event.type == QUIT:
            exit()

