package disk

import (
	"context"
	"errors"
)

type datastore struct {
}

func (d datastore) WriteBlock(ctx context.Context, data []byte, blockName string) error {
	select {
	case <-ctx.Done():
		return errors.New("上下游命令中断") // TODO ：返回错误码
	default:
	}

}

func (d datastore) ReadBlock(ctx context.Context, blockName string) ([]byte, error) {
	select {
	case <-ctx.Done():
		return nil, errors.New("上下游命令中断") // TODO ：返回错误码
	default:
	}
}
