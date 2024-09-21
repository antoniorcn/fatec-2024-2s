import pygame
from pygame.locals import QUIT

screen = pygame.display.set_mode((800, 600), 0, 32)

while True:

    # Calcular as regras

    # Pintar na tela
    screen.fill( (0, 0, 0))

    # Desenhar as bolas
    pygame.draw.circle(screen, center=(200, 150), 
                       radius=50, color=(255, 255, 0), width=5)
    pygame.draw.circle(screen, center=(400, 150), 
                       radius=50, color=(255, 255, 0), width=5)
    pygame.draw.circle(screen, center=(600, 150), 
                       radius=50, color=(255, 255, 0), width=5)
    pygame.draw.circle(screen, center=(200, 300), 
                       radius=50, color=(255, 255, 0), width=5)
    pygame.draw.circle(screen, center=(400, 300), 
                       radius=50, color=(255, 255, 0), width=5)
    pygame.draw.circle(screen, center=(600, 300), 
                       radius=50, color=(255, 255, 0), width=5)
    pygame.draw.circle(screen, center=(200, 450), 
                       radius=50, color=(255, 255, 0), width=5)
    pygame.draw.circle(screen, center=(400, 450), 
                       radius=50, color=(255, 255, 0), width=5)
    pygame.draw.circle(screen, center=(600, 450), 
                       radius=50, color=(255, 255, 0), width=5)
    

    pygame.display.update()

    for event in pygame.event.get():
        if event.type == QUIT:
            exit()

