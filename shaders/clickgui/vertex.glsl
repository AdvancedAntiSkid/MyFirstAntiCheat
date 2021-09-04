#version 400 core

in vec2 position;
in vec2 texturePos;
in mat4 projectionMatrix, viewMatrix;
in sampler2D sampler;

out vec3 color;

void main(void) {
  gl_Position = vec3(position, 1.0) * projectionMatrix * viewMatrix;
  color = texture(sampler, texturePos);
}
