import pygame
from pygame.locals import QUIT, K_RIGHT, K_LEFT, KEYDOWN, KEYUP

AMARELO = (255, 255, 0)
PRETO = (0, 0, 0)
ROXO = (255, 0, 255)
VERMELHO = (255, 0, 0)

def intercalou(min_a, max_a, min_b, max_b):
    return (min_a <= min_b and max_a >= min_b) or\
    (max_b >= min_a and max_b <= max_a)

def colisao_rect( rect_a, rect_b):
    min_a = rect_a[0][0]
    max_a = min_a  + rect_a[1][0]
    min_b = rect_b[0][0]
    max_b = min_b  + rect_b[1][0]
    colidiu_x = intercalou(min_a, max_a, min_b, max_b)
    # ( (x, 150), (50, 50) )
    min_a = rect_a[0][1]
    max_a = min_a  + rect_a[1][1]
    min_b = rect_b[0][1]
    max_b = min_b  + rect_b[1][1]
    colidiu_y = intercalou(min_a, max_a, min_b, max_b)
    return colidiu_x and colidiu_y

pygame.init()
screen = pygame.display.set_mode( (800, 600), 0, 32 )
x = 0.0
vx = 0.0
cor_retangulo1 = AMARELO
while True:
    # Calcular Regras
    x = x + vx
    retangulo1 = ( (x, 150), (50, 50) )
    retangulo2 = ( (500, 180), (50, 50) )

    if colisao_rect(retangulo1, retangulo2):
        cor_retangulo1 = VERMELHO
    else:
        cor_retangulo1 = AMARELO

    # Desenhar
    screen.fill( PRETO )
    pygame.draw.rect( screen, cor_retangulo1, retangulo1, 0)
    pygame.draw.rect( screen, ROXO, retangulo2, 0)
    pygame.display.update()

    # Capturar Eventos
    for event in pygame.event.get():
        if event.type == QUIT:
            exit(0)
        elif event.type == KEYDOWN:
            if event.key == K_RIGHT:
                vx = 0.1
        elif event.type == KEYUP:
            if event.key == K_RIGHT:
                vx = 0.0