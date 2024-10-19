import pygame
from pygame.locals import QUIT

# Cores
PRETO = (0, 0, 0)
AMARELO = (255, 255, 0)

pygame.init()

screen = pygame.display.set_mode((800, 600), 0, 32)

x_start = 75
largura = 60
altura = 60
y = 100
sair = False
while not sair:
    # Calcular regras

    # Denhar tela
    screen.fill( PRETO )
    for coluna in range(8):
        x = x_start + (coluna * largura)
        pygame.draw.rect( screen, AMARELO,
                         ( (x, y), (largura, altura) ), 3 )
    pygame.display.update()
    
    # Capturar eventos
    for event in pygame.event.get():
        if event.type == QUIT:
            sair = True