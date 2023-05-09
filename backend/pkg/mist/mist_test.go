package mist

import "testing"

func BenchmarkMist_Generate(b *testing.B) {
	m := NewMist()
	for i := 0; i < b.N; i++ {
		_ = m.Generate()
	}
}
