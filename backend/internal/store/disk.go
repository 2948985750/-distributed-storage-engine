package store

import "context"

type DiskStore interface {
	WriteBlock(ctx context.Context, data []byte, blockName string) error
	ReadBlock(ctx context.Context, blockName string) ([]byte, error)
}
